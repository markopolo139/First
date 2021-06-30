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

    public static BloodType fromString(String bloodType) {
        for(BloodType bt : BloodType.values()) {
            if(bt.getBloodType().equals(bloodType)) {
                return bt;
            }
        }
        throw new IllegalStateException();
    }
}
