INSERT INTO authors VALUES (next value for s_author_id, 'George', 'Orwell', '1903-06-25', 1903, null);
INSERT INTO authors VALUES (next value for s_author_id, 'Paulo', 'Coelho', '1947-08-24', 1947, null);

INSERT INTO books VALUES (1, 1, null, '1984');
INSERT INTO books VALUES (2, 1, null, 'Animal Farm');
INSERT INTO books VALUES (3, 2, null, 'O Alquimista');
INSERT INTO books VALUES (4, 2, null, 'Brida');

INSERT INTO book_stores (name) VALUES
	('Orell Füssli'),
	('Ex Libris'),
	('Buchhandlung im Volkshaus');

INSERT INTO books_to_book_stores VALUES
	('Orell Füssli', 1, 10),
	('Orell Füssli', 2, 10),
	('Orell Füssli', 3, 10),
	('Ex Libris', 1, 1),
	('Ex Libris', 3, 2),
	('Buchhandlung im Volkshaus', 3, 1);
