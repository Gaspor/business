package business.shared;

public class funcionario {

    private String nome, telefone, data, cargo, salario;
    private long id;

    public funcionario(String nome, String telefone, String data, String cargo, String salario, long id) {
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.cargo = cargo;
        this.salario = salario;
        this.id = id;
    }

    public funcionario(String nome, String telefone, String data, String cargo, String salario) {
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.cargo = cargo;
        this.salario = salario;
    }

    public funcionario() {

    }

    public funcionario(String nome, String telefone, String cargo, String salario, long id) {
        this.id = id; 
        this.nome = nome;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
