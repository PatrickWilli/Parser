/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import parser.database.ReadFromDB;

/**
 *
 * @author phamm
 */
public class TEST
{
    public static void main(String[] args)
    {
        ReadFromDB rfmd = new ReadFromDB("localhost", "3306", "jpa", "root", "");
        rfmd.readTable("csvdata");
    }
    
}
