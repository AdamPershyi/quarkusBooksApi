CREATE TABLE author (
                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        name VARCHAR(255) NOT NULL,
                        bio TEXT
);

-- Створення таблиці "book" з використанням UUID
CREATE TABLE book (
                      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                      title VARCHAR(255) NOT NULL,
                      publication_date DATE,
                      author_id UUID,
                      FOREIGN KEY (author_id) REFERENCES author(id)
);