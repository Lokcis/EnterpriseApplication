/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto;

import javax.ejb.Stateless;

/**
 *
 * @author lokci
 */
@Stateless
public class callBean implements callBeanLocal {

    @Override
    public Integer addition(int a, int b) {
        return a + b;
    }

    @Override
    public Integer subtraction(int a, int b) {
        return a - b;
    }

    @Override
    public Integer multiplication(int a, int b) {
        return a * b;
    }

    @Override
    public Integer division(int a, int b) {
        if (b == 0) {
            return null;
        }
        return a / b;
    }

    @Override
    public Integer modulo(int a, int b) {
        if (b == 0) {
            return null;
        }
        return a % b;
    }

    @Override
    public Integer square(int a) {
        return a * a;
    }
}
