create view show_authors_of_single_books_taken_by_students
as select a.name as authors, s.name as students, b.name as books from students as s
join orders o on s.id = o.student_id
join books b on o.book_id = b.id
join authors a on b.author_id = a.id
group by (s.name, a.name, b.name) having count(a.name) = 1;