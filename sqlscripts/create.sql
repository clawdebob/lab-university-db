create table study_group (
    id int not null AUTO_INCREMENT,
    name text,
    primary key (id)
);

create table student (
    id int not null AUTO_INCREMENT,
    surname text,
    name text,
    second_name text,
    study_group_id int,
    primary key (id),
    foreign key (study_group_id) references study_group(id)
);

create table subject (
    id int not null AUTO_INCREMENT,
    name text,
    short_name text,
    primary key (id)
);

create table exam_type (
    id int not null AUTO_INCREMENT,
    type text,
    primary key (id)
);

create table study_plan (
    id int not null AUTO_INCREMENT,
    subject_id int,
    exam_type_id int,
    primary key (id),
    foreign key (subject_id) references subject(id),
    foreign key (exam_type_id) references exam_type(id)
);

create table mark (
    id int not null AUTO_INCREMENT,
    name text,
    value text,
    primary key (id)
);

create table journal (
    id int not null AUTO_INCREMENT,
    student_id int,
    study_plan_id int,
    in_time bit,
    count int,
    mark_id int,
    primary key (id),
    foreign key (student_id) references student(id),
    foreign key (study_plan_id) references study_plan(id),
    foreign key (mark_id) references mark(id)
);