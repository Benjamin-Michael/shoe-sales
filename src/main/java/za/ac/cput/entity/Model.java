package za.ac.cput.entity;

public class Model {


    private String modelId, modelName, modelDescription;

    private Model(Builder builder) {
        this.modelId = builder.modelId;
        this.modelName = builder.modelName;
        this.modelDescription = builder.modelDescription;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelId='" + modelId + '\'' +
                ", modelName='" + modelName + '\'' +
                ", modelDescription='" + modelDescription + '\'' +
                '}';
    }

    public static class Builder{
        private String modelId, modelName, modelDescription;

        public Builder setModelId(String modelId) {
            this.modelId = modelId;

           return this;
        }

        public Builder setModelName(String modelName) {
            this.modelName = modelName;

            return this;
        }

        public Builder setModelDescription(String modelDescription) {
            this.modelDescription = modelDescription;

            return this;
        }
        public Model build(){

            return new Model (this);
        }
        public  Builder copy (Model model){
            this.modelId = model.modelId;
            this.modelName = model.modelName;
            this.modelDescription = model.modelDescription;
            return this;
        }

    }
}
