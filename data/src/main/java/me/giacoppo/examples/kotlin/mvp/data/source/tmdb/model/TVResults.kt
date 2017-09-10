package me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model

import com.google.gson.annotations.SerializedName

data class TVResults(

		@field:SerializedName("page")
	val page: Int? = null,

		@field:SerializedName("total_pages")
	val totalPages: Int? = null,

		@field:SerializedName("results")
	val results: List<TVShow>? = ArrayList(),

		@field:SerializedName("total_results")
	val totalResults: Int? = null
)