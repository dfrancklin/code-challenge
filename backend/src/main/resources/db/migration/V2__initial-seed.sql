-- CATEGORIES
insert into category (name, description)
values
    ('RESEARCHING', 'Researching'),
    ('PRACTICING', 'Practicing'),
    ('WATCHING_VIDEOS', 'Watching Videos');

-- ADMIN USER
insert into account (first_name, last_name, birth_date, address, city, state, zip_code, email, phone_number, password, role)
values
    (
        'Admin',
        'User',
        '1993-07-12',
        'Some Street',
        'Any City',
        'State',
        '000000000',
        'admin.user@email.com',
        '+55 (00) 99999-9999',
        '$2a$12$mEKl/K7b256hVUvnvAjNA.tb4rtT9u8At9PL9MJsaeL3OxMD5lWLO',
        'ROLE_ADMIN'
    ),
    (
        'Test',
        'User',
        '2002-01-30',
        'Some Street',
        'Any City',
        'State',
        '000000000',
        'test.user@email.com',
        '+55 (15) 99999-9999',
        '$2a$12$mEKl/K7b256hVUvnvAjNA.tb4rtT9u8At9PL9MJsaeL3OxMD5lWLO',
        'ROLE_STUDENT'
    );

-- COURSES
insert into course (name, description, creator_id)
values
    ('COURSE TEST 1', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 2', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 3', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 4', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 5', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 6', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 7', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 8', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 9', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 10', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 11', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 12', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 13', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 14', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1),
    ( 'COURSE TEST 15', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, rem rerum itaque optio explicabo aperiam delectus mollitia quasi quos quis possimus culpa debitis nostrum laboriosam necessitatibus illo nesciunt ducimus voluptas.', 1);

-- ENROLLMENTS
insert into enrollment (status, started_at, updated_at, completed_at, student_id, course_id)
values
    ('IN_PROGRESS', now(), null, null, 2, 1),
    ('IN_PROGRESS', now(), null, null, 2, 2),
    ('COMPLETED', now(), null, null, 2, 3);
