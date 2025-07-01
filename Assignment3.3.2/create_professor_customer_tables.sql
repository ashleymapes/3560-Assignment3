-- Drop tables if they already exist (for reset purposes)
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS customer;

-- Create the Customer table
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- Create the Professor table
CREATE TABLE professor (
    id SERIAL PRIMARY KEY,
    office_number VARCHAR(50) NOT NULL,
    research_area VARCHAR(100) NOT NULL,
    customer_id INT UNIQUE,
    CONSTRAINT fk_customer_professor
        FOREIGN KEY (customer_id) REFERENCES customer(id)
        ON DELETE CASCADE
);
