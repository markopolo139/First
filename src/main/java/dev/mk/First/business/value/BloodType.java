package dev.mk.First.business.value;

public enum BloodType {
    O_PLUS {
        @Override
        public String getBloodType() {
            return "0+";
        }
    },
    O_MINUS {
        @Override
        public String getBloodType() {
            return "0-";
        }
    },
    A_PLUS {
        @Override
        public String getBloodType() {
            return "A+";
        }
    },
    A_MINUS {
        @Override
        public String getBloodType() {
            return "A-";
        }
    },
    B_PLUS {
        @Override
        public String getBloodType() {
            return "B+";
        }
    },
    B_MINUS {
        @Override
        public String getBloodType() {
            return "B-";
        }
    },
    AB_PLUS {
        @Override
        public String getBloodType() {
            return "AB+";
        }
    },
    AB_MINUS {
        @Override
        public String getBloodType() {
            return "AB-";
        }
    };

    public abstract String getBloodType();

}
