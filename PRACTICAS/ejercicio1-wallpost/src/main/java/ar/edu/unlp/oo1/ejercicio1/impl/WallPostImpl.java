package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	
	private String text;
	private int likes;
	private boolean featured;
	
	public WallPostImpl () {
		this.text = "Undefined post";
		this.likes = 0;
		this.featured = false;
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

	@Override
	public String getText() {
		/**
		 * Retorna el texto descriptivo de la publicación
		 * 
		 * @return
		 */
		return this.text;
	}

	@Override
	public void setText(String text) {
		/**
		 * Setea el texto descriptivo de la publicación
		 * @param text
		 */
		this.text = text;
	}

	@Override
	public int getLikes() {
		/**
		 * Retorna la cantidad de “me gusta”
		 * 
		 * @return
		 */
		return this.likes;
	}

	@Override
	public void like() {
		/**
		 * Incrementa la cantidad de likes en uno
		 */
		this.likes++;
		
	}

	@Override
	public void dislike() {
		/**
		 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada
		 */
		if (this.likes > 0)
			this.likes--;
	}

	@Override
	public boolean isFeatured() {
		/**
		 * Retorna true si el post está marcado como destacado, false en caso contrario
		 * 
		 * @return
		 */
		return this.featured;
	}

	@Override
	public void toggleFeatured() {
		/**
		 * Cambia el post del estado destacado a no destacado y viceversa
		 */
		if (!this.featured)
			this.featured  = true;
			else
				this.featured = false;
	}


}
