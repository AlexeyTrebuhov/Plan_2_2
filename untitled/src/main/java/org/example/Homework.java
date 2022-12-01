package org.example;

//TODO: �������� ������
// 1.  ���������� ����� generateEmploeyee(), ������� ���������� ������������� ����.
// 2***. ����� generateEmploeyee() ������ ���� ��� ������� ����������, ��� ����������,
// ��� � ������ ������������ �������������.

import java.util.Arrays;
public class Homework {

       public static Object[] generateEmploeyee() {

        String[] names = new String[]{"Sigizmund ", "Kayrat ", "Oljas ", "Daniyar ", "Arnold ", "Vano "};
        String[] surnames = new String[]{"Ivanov ", "Petrov ", "Syleimenov ", "Malkin ", "Zverev ", "Golubev "};
        int[] id = new int[]{1, 2}; // ��� ���������� ���������
        int[] salarys = new int[]{30000, 50000, 70000, 900000};

        String Rnames = names[(int) Math.floor(Math.random() * names.length)];
        String Rsurnames = surnames[(int) Math.floor(Math.random() * surnames.length)];
        int Rid = id[(int) Math.floor(Math.random() * id.length)];
        int Rsalarys = salarys[(int) Math.floor(Math.random() * salarys.length)];

        Object[] result = new Object[4];// ������ �� ������ ����� ������
        result[0] = Rnames;
        result[1] = Rsurnames;
        result[2] = Rid;
        result[3] = Rsalarys;

        return result;
    }

    public static void main(String[] args) {

        String generateName = (String) generateEmploeyee()[0]; // �������� ������ �� ������
        String generateSurname = (String) generateEmploeyee()[1];
        Integer generateId = (Integer) generateEmploeyee()[2]; // ��� ������ 1 ��� 2
        Integer generateSalary = (Integer) generateEmploeyee()[3];

        String[] split = Arrays.toString(generateEmploeyee()).split(",");// ������� ������ �� �������, ������ ��
        //System.out.println(split[2]);// �������� ��� �� ������ 1 ��� 2

        Worker worker1 = new Worker("Other","other",2);
        Freelancer freelansee1 = new Freelancer("Other","other",2);

            Object[] employees = new Employee[10]; // ������� ������ Employee �� 10 ������

            for (int i = 0; i < employees.length; i++){

                if (Double.valueOf(String.valueOf(generateEmploeyee()[2])) == 1) { // �������� Woker ��� Freelanse
                    employees[i] = worker1;;
                } else {
                    employees[i] = freelansee1;;
                }
            }
            for (Object employee : employees) {

                System.out.println(employee );
                //System.out.println(Double.valueOf(String.valueOf(generateEmploeyee()[2]))); // ��� ��� �������� ��������� 1 ��� 2

            }
        }
    }



// ������� ������� ����� ���������
    abstract class Employee extends  Homework{// ����� �������� ������
        protected String name;
        protected String surname;
        protected double salary;

        public String getName() { return name; } // ������
        public void setName(String name) {this.name = name; } // ������

        public String getSurname() {return surname; } // ������
        public void setSurname(String surname) {this.surname = surname;} // ������

        public double getSalary() { return salary;} // ������
        public void setSalary(double salary) {this.salary = salary;} // ������

        public Employee(String name, String surname, double salary) {
            this.name = name;
            this.surname = surname;
            this.salary = salary;
        }
        public abstract double calculateSalary();// ������ �������������� ���������� �����
        public abstract String oldname();// ���������� ���
        public abstract String oldsurname();// ���������� �������
        public abstract Double oldsalary();// ���������� ��������
    }

    class Freelancer extends Employee{
    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }
        @Override
        public double calculateSalary() {
        return 15 * 6 * oldsalary() / 22 / 8;
        }

        @Override
        public String oldname() {
        return String.valueOf(generateEmploeyee()[0]);
        }

        @Override
        public String oldsurname() {
        return String.valueOf(generateEmploeyee()[1]);
        }

        @Override
        public Double oldsalary() {
        return Double.valueOf(String.valueOf(generateEmploeyee()[3]));
        }

        @Override
        public String toString() {
        return String.format("%s %s; Freelansee; Average monthly salary: %.2f (rub.); Fixed rate:: %.2f (rub.)",
        oldname(), oldsurname(), calculateSalary(), oldsalary());
    }
}



    class Worker extends Employee{
    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }
        @Override
        public double calculateSalary() {
        return salary;
        }

        @Override
        public String oldname() {
        return String.valueOf(generateEmploeyee()[0]); // 10 ������� ����������;
        }

        @Override
        public String oldsurname() {
            return String.valueOf(generateEmploeyee()[1]);
        }

        @Override
        public Double oldsalary() {
            return Double.valueOf(String.valueOf(generateEmploeyee()[3]));
        }

        @Override
        public String toString() {
        return String.format("%s %s;Worker; Average monthly salary:(Fixed rate): %.2f (rub.)",
        oldname(), oldsurname(), oldsalary());
    }
}