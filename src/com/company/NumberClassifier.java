package com.company;

import java.util.HashSet;
import java.util.Set;

public class NumberClassifier {
    private Set<Integer> _factors;
    private int _number;
    private int _sum;

    public NumberClassifier (int number){
        _number = number;
        _factors = new HashSet<Integer>();
        _factors.add(1);
        _factors.add(_number);
        _sum=0;
    }

    private boolean isFactor(int factor){
        return _number % factor ==0;
    }

    private void calculateFactors(){
        for (int i=1; i <= java.lang.Math.sqrt(_number)+1; i++)
            if (isFactor(i)) addFactor(i);
    }

    private void addFactor(int factor) {
        _factors.add(factor);
        _factors.add(_number/factor);
    }

    private void sumFactors(){
        calculateFactors();
        for (int i: _factors)
            _sum +=i;
    }

    private int getSum(){
        if (_sum ==0)
            sumFactors();
        return _sum;
    }

    public boolean isPerfect(){
        return getSum() - _number == _number;
    }

    public boolean isAbundant(){
        return getSum() - _number > _number;
    }

    public boolean isDeficient(){
        return getSum() - _number < _number;
    }
}
