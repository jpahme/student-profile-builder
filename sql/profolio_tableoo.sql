

CREATE TABLE app_user (
  user_id SERIAL PRIMARY KEY,
  user_name varchar(32) NOT NULL UNIQUE,
  password varchar(32) NOT NULL,
  role smallint NOT NULL default 5,
  salt varchar(255) NOT NULL
);

CREATE TABLE student_profile (

        student_id serial PRIMARY KEY,
        last_name varchar(100) NOT NULL,
        first_name varchar(100) NOT NULL,
        image_link varchar (200),
        summary varchar(1000),
        soft_skils varchar(1000),
        cohort varchar(100),
        phone_number int,
        date_of_birth date    
);

CREATE TABLE skills(

        skills_id serial PRIMARY KEY,        
        technology varchar(100),
        description varchar(1000)
     
);

CREATE TABLE student_skills(

        student_id int NOT NULL,
        skills_id int NOT NULL,
        
        CONSTRAINT fk_student_profile FOREIGN KEY (student_id) REFERENCES student_profile(student_id),
        CONSTRAINT fk_skills FOREIGN KEY (skills_id) REFERENCES skills(skills_id)    
);

CREATE TABLE academic_bg(

        academic_id serial PRIMARY KEY,
        school varchar(100) NOT NULL,
        start_date date,
        end_date date,
        major varchar(100),
        minor varchar(100),
        gpa decimal(3,2),
        city varchar(100),
        state varchar(100),
        country varchar(100),
        website varchar(100), 
        cohort varchar(100)
);

CREATE TABLE student_academic_bg (
        
        academic_id int,
        student_id int,
        
        CONSTRAINT fk_student_profile FOREIGN KEY (student_id) REFERENCES student_profile(student_id),
        CONSTRAINT fk_academic_bg FOREIGN KEY (academic_id) REFERENCES academic_bg(academic_id)  
);

CREATE TABLE experience(

        experience_id serial,
        job_title varchar(100),
        employer_name varchar(100),
        job_descrption varchar(1000),
        start_date date,
        end_date date,
        
        CONSTRAINT pk_experience PRIMARY KEY (experience_id)
);

CREATE TABLE student_experience(

        student_id int NOT NULL,
        experience_id int NOT NULL,
        
        CONSTRAINT fk_student_profile FOREIGN KEY (student_id) REFERENCES student_profile(student_id),
        CONSTRAINT fk_experience FOREIGN KEY (experience_id) REFERENCES experience(experience_id) 
);

CREATE TABLE portfolios(

        portfolio_id serial,
        title varchar(100) NOT NULL,
        start_date date,
        end_date date,
        description varchar(1000) NOT NULL,
        link varchar(200),
        image_image varchar(200),
        
        CONSTRAINT pk_portfolios PRIMARY KEY (portfolio_id)
);

CREATE TABLE student_portfolios(

        student_id int NOT NULL,
        portfolio_id int NOT NULL,
        
        CONSTRAINT fk_student_profile FOREIGN KEY (student_id) REFERENCES student_profile(student_id),
        CONSTRAINT fk_portfolios FOREIGN KEY (portfolio_id) REFERENCES portfolios(portfolio_id)  
);

CREATE TABLE employer_profile (

        employer_id serial PRIMARY KEY,
        name varchar(100) NOT NULL,
        summary varchar(1000),
        image_link varchar(200)
        
);

CREATE TABLE staff_profile (

        staff_id serial PRIMARY KEY,
        name varchar(100) NOT NULL,
        summary varchar(1000),
        image_link varchar(200)
        
);

CREATE TABLE blogs(

        blog_id serial,
        student_id int,
        employer_id int,
        staff_id int,
        title varchar(200) NOT NULL,
        blog varchar(3000) NOT NULL,
        image_link varchar(200),
        
        CONSTRAINT pk_blogs PRIMARY KEY (blog_id),
        CONSTRAINT fk_student_profile FOREIGN KEY (student_id) REFERENCES student_profile(student_id),
        CONSTRAINT fk_employer_profile FOREIGN KEY (employer_id) REFERENCES employer_profile(employer_id),
        CONSTRAINT fk_staff_profile FOREIGN KEY (staff_id) REFERENCES staff_profile(staff_id)

);

CREATE TABLE blog_author (
        
        ba_id serial,
        student_id int,
        employer_id int,
        staff_id int,
        blog_id int NOT NULL,
        
        CONSTRAINT pk_blog_author PRIMARY KEY (ba_id),
        CONSTRAINT fk_blogs FOREIGN KEY (blog_id) REFERENCES blogs(blog_id),
        CONSTRAINT fk_student_profile FOREIGN KEY (student_id) REFERENCES student_profile(student_id),
        CONSTRAINT fk_employer_profile FOREIGN KEY (employer_id) REFERENCES employer_profile(employer_id),
        CONSTRAINT fk_staff_profile FOREIGN KEY (staff_id) REFERENCES staff_profile(staff_id)

);

CREATE TABLE student_user (
        
        user_id int,
        student_id int,
        
        CONSTRAINT fk_app_user FOREIGN KEY (user_id) REFERENCES app_user(user_id),
        CONSTRAINT fk_student_profile FOREIGN KEY (student_id) REFERENCES student_profile(student_id)                
);

CREATE TABLE employer_user (
        
        user_id int,
        employer_id int,
        
        CONSTRAINT fk_app_user FOREIGN KEY (user_id) REFERENCES app_user(user_id),
        CONSTRAINT fk_employer_profile FOREIGN KEY (employer_id) REFERENCES employer_profile(employer_id)                
);

CREATE TABLE staff_user (
        
        user_id int,
        staff_id int,
        
        CONSTRAINT fk_app_user FOREIGN KEY (user_id) REFERENCES app_user(user_id),
        CONSTRAINT fk_staff_profile FOREIGN KEY (staff_id) REFERENCES staff_profile(staff_id)                
);


