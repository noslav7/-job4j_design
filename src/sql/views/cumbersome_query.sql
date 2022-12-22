select s.name, a.name as authors from students as s
join orders o on s.id = o.student_id
join books b on o.book_id = b.id
join authors a on b.author_id = a.id
group by (a.name,s.name)