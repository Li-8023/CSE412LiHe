
public class item {
	private String itemDetails;
	private int quantity;
	private double itemPrice;
	private double totalPrice;
	private int productId;
	
	public item(String itemDetails, int quantity, double totalPrice)
	{
		// generate product id
		if (itemDetails.equals("Blouse")) {
			this.productId = 1;
		}
		else if (itemDetails.equals("Coat")) {
			this.productId = 2;
		}
		else if (itemDetails.equals("Dress")) {
			this.productId = 3;
		}
		else if (itemDetails.equals("Dungarees")) {
			this.productId = 4;
		}
		else if (itemDetails.equals("Pajama")) {
			this.productId = 5;
		}
		else if (itemDetails.equals("Suit")) {
			this.productId = 6;
		} else {
			this.productId = -999;
			System.out.println("UNIDENTIFIED ITEM");
		}
		this.itemDetails = itemDetails;
		this.quantity = quantity;
		
		this.totalPrice = totalPrice;
	}
	
	public String getItemDetails()
	{
		return itemDetails;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public int getProductId() {
		return productId;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}
	
	public void setItemDetails(String itemDetails)
	{
		this.itemDetails = itemDetails;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public void setTotalPrice(float totalPrice)
	{
		this.totalPrice = totalPrice;
	}
}
