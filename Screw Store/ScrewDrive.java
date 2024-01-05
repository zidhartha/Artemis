public enum ScrewDrive{
     SlotDrive {
         @Override
         public String toString() {
             return "SlotDrive";
         }

     }, Cross{
        public String toString() {
            return "Cross";
        }

    }, Hex{
        public String toString() {
            return "Hex";
        }

    }, Torx{
        public String toString() {
            return "Torx";
        }

    };
}
