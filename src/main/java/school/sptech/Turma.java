package school.sptech;

public class Turma {

    private String nome;


    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;


    public Double getMensalidade() {
        return mensalidade;
    }
    public String getNome() {
        return nome;
    }
    //getAtiva
    public Boolean getAtiva() {
        return ativa;
    }
    //getQtdAluno
    public Integer getQtdAluno() {
        return qtdAluno;
    }
    // set nome
    public void setNome(String nome) {
        this.nome = nome;
    }


    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;

    }

    public void matricular(Integer qtd){
       if(qtd == null){
           return;
       }
       else if(qtd >0 && getAtiva() == true){
            this.qtdAluno +=qtd;
        }
    }
    public Integer cancelar(Integer qtd){
        if(qtd == null){
            return null;
        }
        else if(qtd >0 && qtd <= getQtdAluno() && getAtiva() == true){
            this.qtdAluno-=qtd;
            return qtd;
        }
        else {
            return null;
        }
    }
    public Integer desativar(){
       Integer qtd=0;
        if(getAtiva() == false){
            return null;
        } else{
            this.ativa = false;
            qtd += getQtdAluno();
            this.qtdAluno=0;
            return qtd;
        }
    }
    public void transferir(Turma destino, Integer qtdATransferir){
        if(qtdATransferir == null){
            return;
        }
        else if(getQtdAluno() == null){
            return;
        }

        else if(getAtiva() == false || destino.ativa == false){
            return;
        } else if(qtdATransferir > 0 && getQtdAluno() >= qtdATransferir
        ){
            destino.qtdAluno += qtdATransferir;
            this.qtdAluno-= qtdATransferir;
        }


    }
    public Boolean reajustarMensalidade(Double reajuste){
        if(reajuste == null){
            return false;
        }
        else if(reajuste <= 0 ) {

            return false;
        }
        else{
            this.mensalidade = this.mensalidade * (1 + reajuste);
            return true;
        }


    }





}
