package com.backend.dto;

import java.io.Serializable;

import com.backend.domain.Empreendimento;

public class EmpreendimentoDTO implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private long id;
		private String nome;
		private String atributos;
		private String telefone;
		private Integer coordenadaX;
		private Integer coordenadaY;
		
		public EmpreendimentoDTO() {}
		

		public EmpreendimentoDTO(long id, String nome, String atributos, String telefone, Integer coordenadaX,
				Integer coordenadaY) {
			super();
			this.id = id;
			this.nome = nome;
			this.atributos = atributos;
			this.telefone = telefone;
			this.coordenadaX = coordenadaX;
			this.coordenadaY = coordenadaY;
		}


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getAtributos() {
			return atributos;
		}

		public void setAtributos(String atributos) {
			this.atributos = atributos;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public Integer getCoordenadaX() {
			return coordenadaX;
		}

		public void setCoordenadaX(Integer coordenadaX) {
			this.coordenadaX = coordenadaX;
		}

		public Integer getCoordenadaY() {
			return coordenadaY;
		}

		public void setCoordenadaY(Integer coordenadaY) {
			this.coordenadaY = coordenadaY;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
}
