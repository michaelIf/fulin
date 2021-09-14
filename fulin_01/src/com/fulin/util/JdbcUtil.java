package com.fulin.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcUtil {
    final String URL="jdbc:mysql://localhost:3306/fulin";
    final String USERNAME="root";
    final String PASSWORD="root";
    PreparedStatement ps= null;
    Connection con = null;
}
