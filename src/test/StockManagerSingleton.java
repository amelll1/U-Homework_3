package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.MediaProduct.Genre;

public class StockManagerSingleton {
	List<MediaProduct> mediaproducts = new ArrayList<MediaProduct>();
	List<VinylRecordProduct> vinylrecords = new ArrayList<VinylRecordProduct>();
	List<CDRecordProduct> cdrecords = new ArrayList<CDRecordProduct>();
	List<TapeRecordProduct> taperecords = new ArrayList<TapeRecordProduct>();
	private String inventoryFilePath;
	public StockManagerSingleton(String filePath) {
		inventoryFilePath = filePath;
	}
	public boolean intializeStock() {
		FileInputStream stockManagerData;
		try {
			stockManagerData = new FileInputStream(inventoryFilePath);
			Scanner sc = new Scanner(stockManagerData);
			sc.nextLine();
			while (sc.hasNext()) {
				String csvLine = sc.nextLine();
				String[] arrData = csvLine.split(",");
//				for (String a : arrData) {
//					System.out.println(" - "+ a);
//				}
//				System.out.println("SPACE");
				String type = arrData[0];
				String name = arrData[1];
				double price = Double.valueOf(arrData[2]);
				int year = Integer.valueOf(arrData[3]);
				Genre genre = Genre.valueOf(arrData[4]);
				MediaProduct media = new MediaProduct(name,price,year,genre);
				if (type.equals("Vinyl")) {
					VinylRecordProduct typeMedia = new VinylRecordProduct(name,price,year,genre);
					vinylrecords.add(typeMedia);
				} else if (type.equals("CD")) {
					CDRecordProduct typeMedia = new CDRecordProduct(name,price,year,genre);
					cdrecords.add(typeMedia);
				} else if (type.equals("Tape")) {
					TapeRecordProduct typeMedia = new TapeRecordProduct(name,price,year,genre);
					taperecords.add(typeMedia);
				}
				mediaproducts.add(media);
			}
			stockManagerData.close();
			sc.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		return true;
	}
	public boolean addItem(MediaProduct product) {
		return true;
	}
	public boolean removeItem(MediaProduct product) {
		return true;
	}
	public boolean saveStock() {
		return true;
	}
//	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
//		
//	}
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		
	}
//	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
//		
//	}
//	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
//	
//}
//	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
//	
//}
}
