/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.mongodb.query.parsing.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.Document;
import org.hibernate.ogm.datastore.mongodb.query.impl.MongoDBQueryDescriptor;
import org.hibernate.ogm.datastore.mongodb.query.impl.MongoDBQueryDescriptor.Operation;
import org.hibernate.ogm.query.spi.QueryParsingResult;

/**
 * The result of walking a query parse tree using a {@link MongoDBQueryRendererDelegate}.
 *
 * @author Gunnar Morling
 */
public class MongoDBQueryParsingResult implements QueryParsingResult {

	private final Class<?> entityType;
	private final String collectionName;
	private final Document query;
	private final Document projection;
	private final Document orderBy;
	private final List<String> unwinds;
	private final Operation operation;
	private final AggregationRenderer aggregation;

	public MongoDBQueryParsingResult(Class<?> entityType, String collectionName, Document query, Document projection, Document orderBy, List<String> unwinds, Operation operation, AggregationRenderer aggregation) {
		this.entityType = entityType;
		this.collectionName = collectionName;
		this.query = query;
		this.projection = projection;
		this.orderBy = orderBy;
		this.unwinds = unwinds;
		this.operation = operation;
		this.aggregation = aggregation;
	}

	public Document getQuery() {
		return query;
	}

	public Class<?> getEntityType() {
		return entityType;
	}

	public Document getProjection() {
		return projection;
	}

	public Document getOrderBy() {
		return orderBy;
	}

	public List<String> getUnwinds() {
		return unwinds;
	}

	@Override
	public Object getQueryObject() {
		return new MongoDBQueryDescriptor(
			collectionName,
			operation,
			query,
			projection,
			orderBy,
			null,
			null,
			null,
			unwinds,
			null,
			null,
			null,
			aggregation
		);
	}

	@Override
	public List<String> getColumnNames() {
		return projection != null ? new ArrayList<>( projection.keySet() ) : Collections.<String>emptyList();
	}

	@Override
	public String toString() {
		return "MongoDBQueryParsingResult [entityType=" + entityType.getSimpleName() + ", query=" + query + ", projection=" + projection + "]";
	}
}
