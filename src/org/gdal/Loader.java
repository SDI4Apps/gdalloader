/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gdal;

import org.gdal.gdal.gdal;
import org.gdal.ogr.ogr;

/**
 * This class must be placed in the common class loader location of the
 * application server. In the event of Glassfish this is domain/lib/ext; for
 * Tomcat it must be determined but is likely to be tomcat/lib
 *
 * This class loads the GDAL libraries one time only for the life-time of the
 * server
 *
 * The class must be referenced from the application code using a
 * Class.forName("org.gdal.Loader"); statement
 *
 * This will instantiate the class (only if it hasn't already been done) and
 * execute the code in the static constructor.
 *
 * This generic loader class can in principle be re-used independent of
 * applications.
 *
 */
public class Loader {
    static {
        try {
            gdal.AllRegister();
            ogr.RegisterAll();
            System.out.println("Loaded and registerred all GDAL/OGR drivers");
        } catch (Exception e) {
            System.out.println("Error registering GDAL/OGR dependencies: " + e.toString());
        }
    }
}