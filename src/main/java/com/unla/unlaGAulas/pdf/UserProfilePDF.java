package com.unla.unlaGAulas.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.unlaGAulas.entities.User;

public class UserProfilePDF {
	private List<User> userList;
	
	public UserProfilePDF(List<User> userList) {
		this.userList = userList;
	}
	
	private void writeTableHeader(PdfPTable table) {
		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.black);
		
		PdfPCell cell = null;
		
		cell = new PdfPCell(new Phrase("ID", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Username", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Fecha creacion", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Fecha actualizacion", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Rol de usuario", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Nombre", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Apeliido", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Tipo de documento", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("DNI", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Correo electronico", headerFont));
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
	}
	
	private void writeTableData(PdfPTable table) {
		Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Color.black);
		
		PdfPCell cell = null;
		
		for(User user : userList) {
			cell = new PdfPCell(new Phrase(Integer.toString(user.getId()), cellFont));
			cell.setPadding(5);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getUsername(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getCreatedAt().toString(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getUpdatedAt().toString(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getUserRoles().iterator().next().getRole(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getNombre(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getApellido(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getTipoDeDocumento(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getNroDeDocumento(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(user.getCorreoElectronico(), cellFont));
			cell.setPadding(5);
			table.addCell(cell);
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException  {
        //Document document = new Document(PageSize.A4);
		Document document = new Document(new Rectangle(1000, 612));
        PdfWriter.getInstance(document, response.getOutputStream());
        
        document.open();
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Color.black);
        Paragraph paragraph = new Paragraph("Lista de perfiles de usuario", paragraphFont);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(paragraph);
         
        PdfPTable table = new PdfPTable(10);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1f, 1f, 1.5f, 1.5f, 1f , 1f, 1f, 1f, 1f, 1.2f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
