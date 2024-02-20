# Write your MySQL query statement below
Select teacher_id , Count(Distinct subject_id) as cnt From Teacher Group By teacher_id;