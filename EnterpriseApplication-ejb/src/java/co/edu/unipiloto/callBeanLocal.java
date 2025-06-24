/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto;

import javax.ejb.Local;

/**
 *
 * @author lokci
 */
@Local
public interface callBeanLocal {

    Integer addition(int a, int b);

    Integer subtraction(int a, int b);

    Integer multiplication(int a, int b);

    Integer division(int a, int b);

    Integer modulo(int a, int b);

    Integer square(int a);
}
