create table account (
    id serial primary key not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    birth_date date not null,
    address varchar(150) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    zip_code varchar(25) not null,
    email varchar(255) not null unique,
    phone_number varchar(25) not null,
    password varchar(255) not null,
    role varchar(50) not null,
    enabled boolean default true,
    created_at timestamp default now(),
    updated_at timestamp
);
create table course (
    id serial primary key not null,
    name varchar(100) not null unique,
    description text,
    enabled boolean default true,
    created_at timestamp default now(),
    updated_at timestamp,
    creator_id int not null references account (id) on delete cascade
);
create table enrollment (
    id serial primary key not null,
    status varchar(100) not null,
    started_at timestamp default now(),
    updated_at timestamp,
    completed_at timestamp,
    student_id int not null references account (id) on delete cascade,
    course_id int not null references course (id) on delete cascade,
    unique(course_id, student_id)
);
create table category (
    id serial primary key not null,
    name varchar(100) not null,
    description varchar(100) not null
);
create table time_log (
    id serial primary key not null,
    description text not null,
    started_at timestamp default now(),
    completed_at timestamp,
    created_at timestamp default now(),
    updated_at timestamp,
    student_id int not null references account (id) on delete cascade,
    enrollment_id int not null references enrollment (id) on delete cascade,
    category_id int not null references category (id) on delete cascade
);