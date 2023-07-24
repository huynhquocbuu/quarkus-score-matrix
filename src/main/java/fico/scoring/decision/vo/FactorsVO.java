package fico.scoring.decision.vo;

public class FactorsVO {
    String modelname;
    String namespace;
    java.util.Map<String, Object> vars;

    public FactorsVO(String namespace, String modelname, java.util.Map<String, Object> vars) {
        this.namespace = namespace;
        this.modelname = modelname;
        this.vars = vars;
    }

    public String modelname() {
        return this.modelname;
    }

    public String namespace() {
        return this.namespace;
    }

    public java.util.Map<String, Object> vars() {
        return this.vars;
    }
}
