# Comp3005Assignment3
This is a simple Java application for managing student records in a PostgreSQL database.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)

## Introduction

This is a Java application designed to perform basic CRUD operations (Create, Read, Update, Delete) on a PostgreSQL database containing student records. It provides functionality to retrieve all students, add a new student, update a student's email, and delete a student from the database.

## Features

- Retrieve all student records from the database.
- Add a new student to the database.
- Update a student's email in the database.
- Delete a student record from the database.

## Requirements

- Java Development Kit (JDK)
- PostgreSQL database
- JDBC driver for PostgreSQL

## Setup

1. Create a database in PostgreSQL called students
2. Create the table using the following information
  - student_id: Integer, Primary Key, Auto-increment
  - first_name: Text, Not Null
  - last_name: Text, Not Null
  - email: Text, Not Null, Unique
  - enrollment_date: Date
3. Add initial data below:
  - INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
  - ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
  - ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
  - ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
