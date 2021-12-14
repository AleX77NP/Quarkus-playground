package org.alexandar12

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class BookController {

    private val books: ArrayList<Book> = ArrayList();

    @POST
    fun addBook(book: Book): Book {
        books.add(book)
        return book
    }

    @GET
    fun getBooks() = books

    @GET
    @Path("/{title}")
    fun getBookByTitle(@PathParam("title") title: String): Book? {
        return books.find { it.title == title }
    }
}