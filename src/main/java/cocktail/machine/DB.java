package cocktail.machine;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    protected static String url = "jdbc:postgresql://127.0.0.1:5432/cocktail_machine";

    public Connection connect() {

        String user = "cocktail";
        String password = "IDrinkForFun!"; 
        Connection retConn=null;
        try{
            //Class.forName("src/lib/postgresql-42.2.12.jar");
            Connection con = DriverManager.getConnection(url, user, password);
            retConn = con;
        } //catch (SQLException | ClassNotFoundException ex) {
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return retConn;
    }
    public List<CocktailClass> getAllCocktails(){
        Statement stmt = null;
        Connection c = connect();
        List<CocktailClass> cocktails = new ArrayList<>();
        if ( c != null ){
            try {
                //c.setAutoCommit(false);
    
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM public.cocktails;" );
                while ( rs.next() ) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("name");
                    double cost  = rs.getDouble("cost");
                    boolean alchoolic = rs.getBoolean("alchoolic");
                    List<String> list = getCocktailIngredients(id);
                    String[]  ingredients = new String[list.size()];
                    ingredients = list.toArray(ingredients);
                    System.out.println(ingredients[0]);
                    CocktailClass cocktail = new CocktailClass(name, cost,alchoolic,ingredients, id);
                    cocktails.add(cocktail);
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                //System.exit(0);
            }

        } else {
            System.out.println("connection is null ");
        }
        return cocktails;
    }

    private List<String> getCocktailIngredients(int cocktailId) {
        Statement stmt = null;
        Connection c = connect();
        List<String> list = new ArrayList<>();
        if ( c != null ){
            try {
                c.setAutoCommit(false);
    
                stmt = c.createStatement();
                String query = "SELECT i.name as name FROM public.recipe_def r INNER JOIN public.ingredients i ON i.id = r.ingredient_id WHERE r.cocktail_id="+cocktailId+";";
                ResultSet rs = stmt.executeQuery( query );
                while ( rs.next() ) {
                    String  name = rs.getString("name");
                    System.out.println(name);
                    list.add(name);
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                //System.exit(0);
            }

        }
        return list;
    }

    public boolean InsertReceiptAndOrders( Receipt receipt) {
        Statement stmt = null;
        Connection c = connect();
        int receiptId = 0;
        if (c != null) {
            try {

                String sql = "INSERT INTO public.receipts (amount) VALUES (" + receipt.total + ");";
                PreparedStatement prepstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prepstmt.executeUpdate();

                try {
                    ResultSet generatedKeys = prepstmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        receiptId = generatedKeys.getInt(1);
                        System.out.println("recepit "+receiptId);
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                } catch (Exception e) {
                    System.err.println("dddd");
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    return false;
                }
                stmt = c.createStatement();
                for (Cocktail cocktail : receipt.cockatils) {
                    String query = "INSERT INTO public.orders (receipt_id, cocktail_id) VALUES (" + receiptId + "," + cocktail.getId() + ");";
                    stmt.executeUpdate(query);
                }

                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                return false;
                //System.exit(0);
            }

        }
        receipt.setOrderNumber(receiptId);
        return true;
    }

}