/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.inforX.dal;

import java.sql.*;

public class ModuloConexao {
    // método responsável por estabelecer a conexão com o banco
    public static Connection conector() {
        Connection conexao = null;
        // informações de conexão
        String driver = "com.mysql.jdbc.Driver"; // driver antigo
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "ABc890";

        try {
            // chama o driver
          Class.forName("com.mysql.cj.jdbc.Driver"); // Este é o nome correto e moderno
            // estabelece a conexão
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
           // System.out.println(e);//exibe o erro 
            return null; // apenas retorna null, sem stack trace
        }
    }
}