CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          user_id INT UNIQUE REFERENCES users(id)
);