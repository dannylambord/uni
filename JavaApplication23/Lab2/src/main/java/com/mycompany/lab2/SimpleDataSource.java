package com.mycompany.lab2;


/**
 * ICP-2152 - Java Technologies
 * BSc. Computer Science, Year 2, Semester 2
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * SimpleDataSource
 * 
 * Thin wrapper for JDBC Driver Manager, loading parameters from a specified
 * properties file.
 * 
 * Created 10 February 2017.
 * 
 * @author Gray, Cameron C. <c.gray@bangor.ac.uk>
 */
public class SimpleDataSource {

	private static final String JDBC_DRIVER = "jdbc.driver";
	private static final String JDBC_PASS = "jdbc.pass";
	private static final String JDBC_URL = "jdbc.url";
	private static final String JDBC_USER = "jdbc.user";

	private boolean ready = false;
	private Properties props = new Properties();

	private static SimpleDataSource _INSTANCE;
        
        
	/**
	 * Convenience static accessor.
	 *
	 * @param fileName
	 *            the file name of the desired properties file.
	 * @deprecated 
	 *            Construct an instance of this class instead using
	 *            new SimpleDataSource(InputStream) or new
	 *            SimpleDataSource(Reader).
	 */
	@Deprecated
	public static void init(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
		_INSTANCE = new SimpleDataSource(fileName);
	}

	/**
	 * Convenience static accessor.
	 *
	 * @return    a JDBC connection if possible, null otherwise.
	 * @deprecated
	 *            Use the open() method on an instance of
	 *            this class instead.
	 */
	@Deprecated
	public static Connection getConnection() {
		if (_INSTANCE != null)
			return _INSTANCE.open();


		return null;
	}

	/**
	 * Convenience constructor - File name.
	 * 
	 * @param fileName
	 *            the file name of the desired properties file.
	 * @throws IOException
	 *             if reading the named file is not possible.
	 * @throws FileNotFoundException
	 *             if the named file cannot be found.
	 * @throws IllegalArgumentException
	 *             if the named file does not contain appropriate/complete
	 *             parameters.
	 */
	@Deprecated
	public SimpleDataSource(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
		this(new FileReader(fileName));
	}

	/**
	 * Convenience constructor - InputStream.
	 * 
	 * @param stream
	 *            the InputStream where the properties can be loaded from.
	 * @throws IOException
	 *             if reading from the stream is not possible.
	 * @throws IllegalArgumentException
	 *             if the stream does not contain appropriate/complete
	 *             parameters.
	 */
	public SimpleDataSource(InputStream stream) throws IOException, IllegalArgumentException {
		this(new InputStreamReader(stream));
	}

	/**
	 * Convenience constructor - Reader.
	 * 
	 * @param reader
	 *            the reader pointing to the desired properties.
	 * @throws IOException
	 *             if the reader produces an error.
	 * @throws IllegalArgumentException
	 *             if the reader does not contain appropriate/complete
	 *             parameters.
	 */
	public SimpleDataSource(Reader reader) throws IOException, IllegalArgumentException {
		synchronized (props) {
			props.load(reader);
			ready = checkProperties();
			if (!ready)
				throw new IllegalArgumentException("The supplied properties cannot open a datasource sucessfully.");
		}
	}

	/**
	 * Convenience constructor - properties.
	 * 
	 * @param props
	 *            the properties to use.
	 * @throws IllegalArgumentException
	 *             if the Properties do not contain appropriate/complete
	 *             parameters.
	 */
	@Deprecated
	public SimpleDataSource(Properties props) throws IllegalArgumentException {
		synchronized (props) {
			this.props = props;
			ready = checkProperties();
			if (!ready)
				throw new IllegalArgumentException("The supplied properties cannot open a datasource sucessfully.");
		}
	}

	/**
	 * Return a JDBC Connection to the underlying data source.
	 * 
	 * @return a JDBC Connection
	 * @throws IllegalStateException
	 *             if the connection cannot be provided (due to bad
	 *             initialisation) or has become invalid due to the underlying
	 *             data source becoming invalid.
	 */
	public Connection open() throws IllegalStateException {
		if (!ready)
			throw new IllegalStateException("This datasource is not correctly configured.");

		synchronized (props) {
			try {
				return DriverManager.getConnection(props.getProperty(JDBC_URL), props.getProperty(JDBC_USER),
						props.getProperty(JDBC_PASS));
			} catch (SQLException e) {
				// At this point the database has 'gone away' so reset state.
				ready = false;
				throw new IllegalStateException("The datasource is no longer available. " + e.getLocalizedMessage());
			}
		}
	}

	/**
	 * Re-initialise this data source with new properties.
	 * 
	 * @see StaticDataSource#StaticDataSource(String)
	 */
	@Deprecated
	public void reinitialise(String fileName) throws IOException, FileNotFoundException, IllegalArgumentException {
		reinitialise(new FileReader(fileName));
	}

	/**
	 * Re-initialise this data source with new properties.
	 * 
	 * @see StaticDataSource#StaticDataSource(Reader)
	 */
	public void reinitialise(InputStream stream) throws IOException, IllegalArgumentException {
		reinitialise(new InputStreamReader(stream));
	}

	/**
	 * Re-initialise this data source with new properties.
	 * 
	 * @see StaticDataSource#StaticDataSource(Reader)
	 */
	public void reinitialise(Reader reader) throws IOException, IllegalArgumentException {
		synchronized (props) {
			props.load(reader);
			ready = checkProperties();
			if (!ready)
				throw new IllegalArgumentException("The supplied properties cannot open a datasource sucessfully.");
		}
	}

	/**
	 * Re-initialise this data source with new properties
	 * 
	 * @see StaticDataSource#StaticDataSource(Properties)
	 */
	@Deprecated
	public void reinitialise(Properties props) throws IllegalArgumentException {
		synchronized (props) {
			this.props = props;
			ready = checkProperties();
			if (!ready)
				throw new IllegalArgumentException("The supplied properties cannot open a datasource sucessfully.");
		}
	}

	/**
	 * Determine if the supplied properties are acceptable for use. Checks are
	 * performed for presence and useability.
	 * 
	 * Driver is required and not empty. URL is required and not empty. User is
	 * required and not empty. Password is required, but may be empty.
	 * 
	 * @return true if the properties are acceptable, false otherwise.
	 */
	private boolean checkProperties() {
		boolean propsOK = (props.containsKey(JDBC_URL) && props.getProperty(JDBC_URL) != null
				&& !props.getProperty(JDBC_URL).isEmpty())
				&& (props.containsKey(JDBC_DRIVER) && props.getProperty(JDBC_DRIVER) != null
						&& !props.getProperty(JDBC_DRIVER).isEmpty())
				&& (props.containsKey(JDBC_USER) && props.getProperty(JDBC_USER) != null
						&& !props.getProperty(JDBC_USER).isEmpty())
				&& (props.containsKey(JDBC_PASS) && props.getProperty(JDBC_PASS) != null);

		// If the initial tests are acceptable attempt to validate the
		// parameters using JDBC.
		Connection con = null;
		if (propsOK) {
			try {
				// Attempt to load the class, failure is signalled by the
				// exception/
				Class<?> driverClass = Class.forName(props.getProperty(JDBC_DRIVER));

				// Validate that the supplied class is in fact a JDBC Driver.
				if (!Driver.class.isAssignableFrom(driverClass))
					return false;

				con = DriverManager.getConnection(props.getProperty(JDBC_URL), props.getProperty(JDBC_USER),
						props.getProperty(JDBC_PASS));

				return true;
			} catch (ClassNotFoundException e) {
				// No-op, this is an expected exception.
			} catch (SQLException e) {
				// No-op, this is an expected exception.
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e1) {
						// No-op, we don't care about exceptions here.
					}
				}
			}

		}
		return false;
	}
}