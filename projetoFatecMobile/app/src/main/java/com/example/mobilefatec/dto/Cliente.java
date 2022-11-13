package com.example.mobilefatec.dto;
import java.io.Serializable;


    public class Cliente implements Serializable {
        String id;
        String nome;
        String celular;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        @Override
        public String toString() {
            return "Cliente{" + "id=" + id + ", nome=" + nome + ", celular=" + celular + '}';
        }


    }




