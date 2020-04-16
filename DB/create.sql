DROP TABLE IF EXISTS "public"."ingredients" CASCADE;
DROP TABLE IF EXISTS "public"."recipe_descr" CASCADE;
DROP TABLE IF EXISTS "public"."recipe_def" CASCADE;
DROP TABLE IF EXISTS "public"."cocktails" CASCADE;
DROP TABLE IF EXISTS "public"."receipts" CASCADE;
DROP TABLE IF EXISTS "public"."orders" CASCADE;



CREATE TABLE "public"."ingredients" (
	"id" int PRIMARY KEY NOT NULL,
	"name" character varying UNIQUE NOT NULL
);

-- CREATE TABLE "public"."recipe_descr" (
-- 	"id" int PRIMARY KEY NOT NULL,
-- 	"name" character varying UNIQUE NOT NULL
-- );

CREATE TABLE "public"."recipe_def" (
	"id" int PRIMARY KEY NOT NULL,
	"cocktail_id" int,
    "ingredient_id" int
);

CREATE TABLE "public"."cocktails" (
	"id" int PRIMARY KEY NOT NULL,
	"name" character varying UNIQUE NOT NULL,
    "cost" decimal NOT NULL,
    "alchoolic" boolean NOT NULL DEFAULT TRUE
);

DROP SEQUENCE IF EXISTS public.receipt_seq;
CREATE SEQUENCE public.receipt_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."receipts" (
	"id" int DEFAULT nextval('receipt_seq'::regclass) PRIMARY KEY NOT NULL,
	"amount" decimal NOT NULL,
    "date_time" timestamp without time zone DEFAULT now()
);

DROP SEQUENCE IF EXISTS public.order_seq;
CREATE SEQUENCE public.order_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE "public"."orders" (
	"id" int DEFAULT nextval('order_seq'::regclass) PRIMARY KEY  NOT NULL,
	"receipt_id" int NOT NULL,
    "cocktail_id" int NOT NULL,
    "date_time" timestamp without time zone DEFAULT now()
);

ALTER TABLE "public"."cocktails" DROP CONSTRAINT IF EXISTS "recipe_id_fk";
--ALTER TABLE "public"."cocktails" ADD CONSTRAINT "recipe_id_fk" FOREIGN KEY ("recipe_id") REFERENCES "public"."recipe_descr" ("id");
ALTER TABLE "public"."recipe_def" DROP CONSTRAINT IF EXISTS "recipe_def_recipe_id_fk";
ALTER TABLE "public"."recipe_def" ADD CONSTRAINT "recipe_def_recipe_id_fk" FOREIGN KEY ("cocktail_id") REFERENCES "public"."cocktails" ("id");
ALTER TABLE "public"."recipe_def" DROP CONSTRAINT IF EXISTS "recipe_def_ingredient_id_fk";
ALTER TABLE "public"."recipe_def" ADD CONSTRAINT "recipe_def_ingredient_id_fk" FOREIGN KEY ("ingredient_id") REFERENCES "public"."ingredients" ("id");

ALTER TABLE "public"."orders" DROP CONSTRAINT IF EXISTS "receipt_id_fk";
ALTER TABLE "public"."orders" ADD CONSTRAINT "receipt_id_fk" FOREIGN KEY ("receipt_id") REFERENCES "public"."receipts" ("id");
ALTER TABLE "public"."orders" DROP CONSTRAINT IF EXISTS "cocktail_id_fk";
ALTER TABLE "public"."orders" ADD CONSTRAINT "cocktail_id_fk" FOREIGN KEY ("cocktail_id") REFERENCES "public"."cocktails" ("id");
