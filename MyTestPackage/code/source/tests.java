
// -----( IS Java Code Template v1.2

import static org.junit.Assert.*;

import org.junit.Test;

import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class tests

{
	// ---( internal utility methods )---

	final static tests _instance = new tests();

	static tests _newInstance() {
		return new tests();
	}

	static tests _cast(Object o) {
		return (tests) o;
	}

	// ---( server methods )---

	public static final void TestDocumentToXmlString(IData pipeline) throws ServiceException {
		// --- <<IS-START(TestDocumentToXmlString)>> ---
		// @sigtype java 3.5

		// --- <<IS-END>> ---

	}

	@Test
	public void testDocumentToXMLStringWithNameExists() throws Exception {
		// create a sample input document with a name element
		IData input = IDataFactory.create();
		IDataCursor cursor = input.getCursor();
		cursor.insertAfter("nom", "momo");
		cursor.destroy();

		// invoke the flow service and capture the output
		IData output = Service.doInvoke("namespace:serviceName", "showXmlString", input);

		// verify that the output contains the expected name element
		String xmlOutput = IDataUtil.getString(output.getCursor(), "document");
		assertTrue(xmlOutput.contains("<nom>momo</nom>"));
	}
	
	@Test
	  public void testDocumentToXMLStringWithNameMissing() throws Exception {
	    // create a sample input document without a name element
	    IData input = IDataFactory.create();

	    // invoke the flow service and capture the output
	    IData output = Service.doInvoke("namespace:serviceName", "showXmlString", input);

	    // verify that the output does not contain a name element
	    String xmlOutput = IDataUtil.getString(output.getCursor(), "document");
	    assertFalse(xmlOutput.contains("<nom>"));
	  }
	
}
