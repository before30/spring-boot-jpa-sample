insert into tags(id, name) values (1, 'Spring projects');
insert into tags(id, name) values (2, 'Apache projects');
insert into tags(id, name) values (3, 'Open source');

insert into notes(id, title, body) values (1, 'Spring Boot', 'Takes an opinionated view of building production-ready Spring applications.');
insert into notes(id, title, body) values (2, 'Spring Framework', 'Core support for dependency injection, transaction management, web applications, data access, messaging, testing and more.');
insert into notes(id, title, body) values (3, 'Spring Integration', 'Extends the Spring programming model to support the well-known Enterprise Integration Patterns.');
insert into notes(id, title, body) values (4, 'Tomcat', 'Apache Tomcat is an open source software implementation of the Java Servlet and JavaServer Pages technologies.');

insert into notes_tags(notes_id, tags_id) values (1, 1);
insert into notes_tags(notes_id, tags_id) values (2, 1);
insert into notes_tags(notes_id, tags_id) values (3, 1);
insert into notes_tags(notes_id, tags_id) values (1, 3);
insert into notes_tags(notes_id, tags_id) values (2, 3);
insert into notes_tags(notes_id, tags_id) values (3, 3);
insert into notes_tags(notes_id, tags_id) values (4, 2);
insert into notes_tags(notes_id, tags_id) values (4, 3);