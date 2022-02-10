package com.sbrf.reboot.calculator;

public class Calculator {
    public double getAddition(double firstNumber, double secondNumber)
    {
        return (firstNumber + secondNumber);
    }

    public double getMultiplication(double firstNumber, double secondNumber)
    {
        return (firstNumber * secondNumber);
    }

    public double getSubtraction(double firstNumber, double secondNumber)
    {
        return(firstNumber - secondNumber);
    }

    public double getDivision(double firstNumber, double secondNumber)
    {
        return(firstNumber / secondNumber);
    }

    public double remains(double firstNumber, double secondNumber)
    {
        return (firstNumber % secondNumber);
    }

    public int evenOrOdd(int num)
    {
        return (num % 2);
    }

    public int isPositive(int num)
    {
        if (num > 0)
        {
            return (1);
        }
        else if (num < 0)
        {
            return (-1);
        }
        return (0);
    }

}
