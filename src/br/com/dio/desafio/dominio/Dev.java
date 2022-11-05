package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscristos = new LinkedHashSet<>();
    private Set<Conteudo> contaudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscristos.addAll(bootcamp.getContaudos());
        bootcamp.getDevsInscritos().add(this);

    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscristos.stream().findFirst();
        if(conteudo.isPresent()){
            this.contaudosConcluidos.add(conteudo.get());
            this.conteudosInscristos.remove(conteudo.get());
        }else{
            System.out.println("Você não esta matriculado em nenhum conteúdo");
        }
    }

    public double calcularTotalXp(){
        return this.contaudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscristos() {
        return conteudosInscristos;
    }

    public void setConteudosInscristos(Set<Conteudo> conteudosInscristos) {
        this.conteudosInscristos = conteudosInscristos;
    }

    public Set<Conteudo> getContaudosConcluidos() {
        return contaudosConcluidos;
    }

    public void setContaudosConcluidos(Set<Conteudo> contaudosConcluidos) {
        this.contaudosConcluidos = contaudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscristos, dev.conteudosInscristos) && Objects.equals(contaudosConcluidos, dev.contaudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscristos, contaudosConcluidos);
    }
}
