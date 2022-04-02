package pl.pjait;

import java.util.ArrayList;

public class Invoice {

    public class seller{
        private String sellerName;
        private String address;
        private long nip;
        private long bankAccountNumber;

        public long getBankAccountNumber() {
            return bankAccountNumber;
        }

        public void setBankAccountNumber(long bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public long getNip() {
            return nip;
        }

        public void setNip(long nip) {
            this.nip = nip;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
    public class buyer{
        private String buyerName;
        private String buyerAddress;
        private long nip;

        public String getBuyerAddress() {
            return buyerAddress;
        }

        public void setBuyerAddress(String buyerAddress) {
            this.buyerAddress = buyerAddress;
        }

        public long getBuyerBankAccountNumber() {
            return buyerBankAccountNumber;
        }

        public void setBuyerBankAccountNumber(long buyerBankAccountNumber) {
            this.buyerBankAccountNumber = buyerBankAccountNumber;
        }

        private long buyerBankAccountNumber;

        public String getBuyerName() {
            return buyerName;
        }

        public void setBuyerName(String buyerName) {
            this.buyerName = buyerName;
        }

        public long getNip() {
            return nip;
        }

        public void setNip(long nip) {
            this.nip = nip;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        private String address;
    }

    private ArrayList<InvoicePosition> positions = new ArrayList<InvoicePosition>();

    public ArrayList<InvoicePosition> getPositions() {
        return positions;
    }

    public void addPosition(InvoicePosition position){
        positions.add(position);
    }

    private InvoicePosition positionWithProduct(Product product){
        for(InvoicePosition position: positions)
        {
            if(position.getProduct().getCode().equals(product.getCode()))
                return position;
        }
        return null;
    }

    public void addPosition(Product product) {
        InvoicePosition position = positionWithProduct(product);
        if(position == null){
            addPosition(new InvoicePosition(product));
            return;
        }
        position.setCount(position.getCount()+1);
    }

}
