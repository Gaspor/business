package business.shared;

public class obra {

    private String nomeFuncionario, dataInicio, dataFim, valor, tipo, descObra,
            nomeCliente, ruaCliente, numCasaCliente, bairroCliente, emailCliente, telefoneCliente, status;

    private long id;

    public obra(String nomeFuncionario, String dataInicio, String dataFim, String valor, String tipo, String descObra, String nomeCliente, String ruaCliente, String numCasaCliente, String bairroCliente, String emailCliente, String telefoneCliente, String status, long id) {
        this.nomeFuncionario = nomeFuncionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.tipo = tipo;
        this.descObra = descObra;
        this.nomeCliente = nomeCliente;
        this.ruaCliente = ruaCliente;
        this.numCasaCliente = numCasaCliente;
        this.bairroCliente = bairroCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.status = status;
        this.id = id;
    }

    public obra(String nomeFuncionario, String dataInicio, String dataFim, String valor, String tipo, String descObra, String nomeCliente, String ruaCliente, String numCasaCliente, String bairroCliente, String emailCliente, String telefoneCliente, String status) {
        this.nomeFuncionario = nomeFuncionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.tipo = tipo;
        this.descObra = descObra;
        this.nomeCliente = nomeCliente;
        this.ruaCliente = ruaCliente;
        this.numCasaCliente = numCasaCliente;
        this.bairroCliente = bairroCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.status = status;
    }

    public obra() {

    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescObra() {
        return descObra;
    }

    public void setDescObra(String descObra) {
        this.descObra = descObra;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public String getNumCasaCliente() {
        return numCasaCliente;
    }

    public void setNumCasaCliente(String numCasaCliente) {
        this.numCasaCliente = numCasaCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
