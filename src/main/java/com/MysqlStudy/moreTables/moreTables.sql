/*
    表的关联关系
    1. 一对一关联
    2. 一对多关联
    4. 多对多关联
*/

# 查询员工在哪一个城市工作
select *
from employees
where last_name = 'King';

select *
from departments
where department_id = 10;

select *
from locations
where location_id = 1000;

-- 如何通过多表直接查询

# 错误的实现方式：每个员工都与每个部门匹配了一遍，即笛卡尔积(交叉连接，cross join)的错误
/*
    笛卡尔积：是一个数学运算，假设有两个集合X和Y，那么X和Y的笛卡尔积就是X和Y的所有可能的组合的乘积。
    错误原因：缺少了多表的连接条件
*/
select employee_id,department_name
from employees,departments;

select employee_id,department_name
from employees cross join departments;

select * from employees; -- 查询结果为10条

select * from departments;  -- 查询结果为5条

select 50 / 10
from dual;      -- dual是干什么的？

# 多表查询的正确方法需要有连接条件
select employee_id,department_name
from employees,departments
# 两个表的连接条件
where employees.department_id = departments.department_id;  -- 返回的就是十条记录
/*
    笛卡尔积错误产生的条件：
        1.省略多个表的连接条件
        2.连接条件没有生效
*/

# 如果出现了两个表中都存在的字段，必须指明此字段所在的表
# 建议：从sql优化的角度来看，建议多表查询时，每个字段前都指明其所在的表
select employees.employee_id,departments.department_name,employees.department_id
from employees,departments
where employees.department_id = departments.department_id;  -- 返回的就是十条记录

# 可以给表起别名，在select和where中使用表的别名,但是注意要统一，作用域只在单个语句之内，不能再使用表的原名
select emp.employee_id,dept.department_name,emp.department_id
from employees emp,departments dept
where emp.department_id = dept.department_id;

# 如果有n个表实现多表查询，则需要至少n-1个连接条件
select emp.employee_id,emp.last_name,dep.department_name,loca.city
from employees emp,departments dep,locations loca
where emp.department_id = dep.department_id
and dep.location_id = loca.location_id;

/*
    解决问题的方式：
    演绎式：提出问题1--->解决问题1---->提出问题2---->解决问题2
    归纳式：总---分
*/

# 7 多表查询的分类
/*
    角度一：等值连接。非等值连接
    角度二：自连接。非自连接
    角度三：内连接。 外连接
*/

# 7.1 等值连接和非等值连接
# 非等值连接例子：
select * from job_grades;

select employees.last_name,employees.salary,job_grades.grade_level
from employees,job_grades
where salary between job_grades.lowest_sal and job_grades.highest_sal;

# 7.2 自连接和非自连接
# 上述所写皆为非自连接，自己和自己连接叫做自连接
select * from employees;
# 自连接的案例练习：员工id,员工姓名，及其管理者的id和姓名
select emp.employee_id,emp.last_name,mana.employee_id,mana.last_name
from employees emp , employees mana
where emp.manager_id = mana.employee_id;

# 7.3 内连接和外连接
# 内连接：合并具有同一列的两个以上的表的行，结果集中不包含一个表与ing一个表不匹配的行
select employees.employee_id,departments.department_name
from employees,departments
where employees.department_id = departments.department_id;
# 外连接：合并具有同一列的两个以上的表的行，结果集中除了包含一个表与另一个表匹配的行之外，还查询到了左表或右表中不匹配的行
# 外连接的分类：左外连接，右外连接，满外连接
# 左外连接:两个表在连接过程中除了返回满足连接条件的行于外，还返回左表中不满足条件的行
# 右外连接：两个表在连接过程中除了返回满足连接条件的行以外，还返回右表中不满足条件的行
# 练习：查询员工的last_name,department_name信息

# SQL99语法：使用Join...on语法
# 实现内连接：
select employees.last_name,departments.department_name
from employees join departments
on employees.department_id = departments.department_id;

select e.last_name,d.department_name,l.city
from employees e join departments d
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id;

select e.employee_id,d.department_name
from employees e,departments d
where e.department_id = d.department_id;

