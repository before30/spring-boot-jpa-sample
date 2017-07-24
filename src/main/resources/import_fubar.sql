INSERT INTO author VALUES (1, 'George', 'Orwell');
INSERT INTO author VALUES (2, 'Paulo', 'Coelho');

INSERT INTO book VALUES (1, '1984', 1, null);
INSERT INTO book VALUES (5, 'test', 1, null);
INSERT INTO book VALUES (2, 'Animal Farm', 1, null);
INSERT INTO book VALUES (3, 'O Alquimista', 2, 1 );
INSERT INTO book VALUES (4, 'Brida', 2, null );

INSERT INTO book_store (name) VALUES
  ('Orell'),
  ('Ex Libris'),
  ('Buchhandlung im Volkshaus');

INSERT INTO book_to_book_store VALUES
  (10, 1, 'Orell'),
  (10, 2, 'Orell'),
  (10, 3, 'Orell'),
  (1, 1, 'Ex Libris'),
  (3, 2, 'Ex Libris'),
  (3, 1, 'Buchhandlung im Volkshaus');
