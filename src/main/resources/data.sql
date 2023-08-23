insert into user_details(id,birth_date,name)
values (1001,current_date(),'jitesh');

insert into user_details(id,birth_date,name)
values (1002,current_date(),'gagan');


insert into user_details(id,birth_date,name)
values (1003,current_date(),'vikas');


INSERT INTO post (id,description, user_id) VALUES
    (2001,'I want to Learn AWS', 1001),
    (2002,'I want to Learn DevOPS', 1001),
    (2003,'I want to Learn Spring', 1002);
