package com.gimslab.exposedexam

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CpDbExam {

	fun testExposed(pwd: String) {
		Database.connect("jdbc:mysql://db.seller.coupangdev.com:3306/finance3p", driver = "com.mysql.cj.jdbc.Driver", user = "winter", password = pwd)
//		for (row in GoodsGenObject.select()) {
////			print(row[GoodsGenObject.id].toString() + "\t")
////			println(row[GoodsGenObject.useType])
//			val dto = GoodsGenObjectDto(
//					id = row[GoodsGenObject.id],
//					useType = row[GoodsGenObject.useType],
//					event = row[GoodsGenObject.event],
//					referenceKey = row[GoodsGenObject.referenceKey],
//					modifiedAt = row[GoodsGenObject.modifiedAt]
//			)
//			println(dto)

		transaction {
			for (row in GoodsGenObjects.selectAll()) {
				println(row)
			}
		}
	}
}

object GoodsGenObjects : LongIdTable("goods_gen_object", "goodsGenObjectId") {
	val useType = varchar("useType", 50)
}

class GoodsGenObject(id: EntityID<Long>) : LongEntity(id) {
	companion object : LongEntityClass<GoodsGenObject>(GoodsGenObjects)

	var useType by GoodsGenObjects.useType
}
