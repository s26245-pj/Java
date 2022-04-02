package pl.pjait;

public class Invoice {

    public class seller{
        private String sellerName;
        private long nip;
        private String address;

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
        private long nip;

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





}
