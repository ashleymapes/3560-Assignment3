-- Drop tables if they already exist
DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS "order";  -- Use quotes because "order" is a reserved word

-- Create product table
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Create order table
CREATE TABLE "order" (
    id SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    customer_name VARCHAR(100) NOT NULL
);

-- Create join table
CREATE TABLE order_detail (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES "order"(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);

-- Insert some products
INSERT INTO product (name) VALUES ('Pizza'), ('Coke'), ('Salad');

-- Insert one order
INSERT INTO "order" (date, customer_name) VALUES (CURRENT_DATE, 'Ashley');

-- Link order with products
INSERT INTO order_detail (order_id, product_id) VALUES (1, 1), (1, 2);
