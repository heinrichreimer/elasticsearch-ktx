@file:Suppress("UNUSED")

package dev.reimer.elasticsearch.ktx.client

import dev.reimer.elasticsearch.ktx.util.awaitAction
import org.elasticsearch.action.admin.cluster.node.tasks.list.ListTasksResponse
import org.elasticsearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest
import org.elasticsearch.action.admin.cluster.storedscripts.GetStoredScriptRequest
import org.elasticsearch.action.admin.cluster.storedscripts.GetStoredScriptResponse
import org.elasticsearch.action.admin.cluster.storedscripts.PutStoredScriptRequest
import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.bulk.BulkResponse
import org.elasticsearch.action.delete.DeleteRequest
import org.elasticsearch.action.delete.DeleteResponse
import org.elasticsearch.action.explain.ExplainRequest
import org.elasticsearch.action.explain.ExplainResponse
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesRequest
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesResponse
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.action.get.MultiGetRequest
import org.elasticsearch.action.get.MultiGetResponse
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.action.search.*
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.action.update.UpdateRequest
import org.elasticsearch.action.update.UpdateResponse
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.client.RethrottleRequest
import org.elasticsearch.index.rankeval.RankEvalRequest
import org.elasticsearch.index.rankeval.RankEvalResponse
import org.elasticsearch.index.rankeval.RankEvalSpec
import org.elasticsearch.index.reindex.BulkByScrollResponse
import org.elasticsearch.index.reindex.DeleteByQueryRequest
import org.elasticsearch.index.reindex.ReindexRequest
import org.elasticsearch.index.reindex.UpdateByQueryRequest
import org.elasticsearch.script.ScriptType
import org.elasticsearch.script.mustache.MultiSearchTemplateRequest
import org.elasticsearch.script.mustache.MultiSearchTemplateResponse
import org.elasticsearch.script.mustache.SearchTemplateRequest
import org.elasticsearch.script.mustache.SearchTemplateResponse
import org.elasticsearch.tasks.TaskId

// See [REST APIs on elastic.co](https://www.elastic.co/guide/en/elasticsearch/reference/current/rest-apis.html).

suspend inline fun RestHighLevelClient.bulkAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: BulkRequest.() -> Unit = {}): BulkResponse =
        awaitAction { bulkAsync(options, it, block) }

suspend inline fun RestHighLevelClient.clearScrollAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ClearScrollRequest.() -> Unit = {}): ClearScrollResponse =
        awaitAction { clearScrollAsync(options, it, block) }

// TODO count

suspend inline fun RestHighLevelClient.deleteAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: DeleteRequest.() -> Unit = {}): DeleteResponse =
        awaitAction { deleteAsync(options, it, block) }

suspend inline fun RestHighLevelClient.deleteByQueryAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: DeleteByQueryRequest.() -> Unit = {}): BulkByScrollResponse =
        awaitAction { deleteByQueryAsync(options, it, block) }

suspend inline fun RestHighLevelClient.deleteByQueryRethrottleAsync(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: RethrottleRequest.() -> Unit = {}): ListTasksResponse =
        awaitAction { deleteByQueryRethrottleAsync(taskId, requestsPerSecond, options, it, block) }

suspend inline fun RestHighLevelClient.deleteScriptAsync(id: String, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: DeleteStoredScriptRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { deleteScriptAsync(id, options, it, block) }

suspend inline fun RestHighLevelClient.existsAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetRequest.() -> Unit = {}): Boolean =
        awaitAction { existsAsync(options, it, block) }

// TODO existsSource

suspend inline fun RestHighLevelClient.explainAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ExplainRequest.() -> Unit = {}): ExplainResponse =
        awaitAction { explainAsync(options, it, block) }

suspend inline fun RestHighLevelClient.fieldCapsAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: FieldCapabilitiesRequest.() -> Unit = {}): FieldCapabilitiesResponse =
        awaitAction { fieldCapsAsync(options, it, block) }

suspend inline fun RestHighLevelClient.getAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetRequest.() -> Unit = {}): GetResponse =
        awaitAction { getAsync(options, it, block) }

suspend inline fun RestHighLevelClient.getScriptAsync(id: String, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: GetStoredScriptRequest.() -> Unit = {}): GetStoredScriptResponse =
        awaitAction { getScriptAsync(id, options, it, block) }

suspend inline fun RestHighLevelClient.indexAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: IndexRequest.() -> Unit = {}): IndexResponse =
        awaitAction { indexAsync(options, it, block) }

suspend inline fun RestHighLevelClient.mgetAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: MultiGetRequest.() -> Unit = {}): MultiGetResponse =
        awaitAction { mgetAsync(options, it, block) }

suspend inline fun RestHighLevelClient.msearchAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: MultiSearchRequest.() -> Unit = {}): MultiSearchResponse =
        awaitAction { msearchAsync(options, it, block) }

suspend inline fun RestHighLevelClient.msearchTemplateAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: MultiSearchTemplateRequest.() -> Unit = {}): MultiSearchTemplateResponse =
        awaitAction { msearchTemplateAsync(options, it, block) }

// TODO mtermvectors

suspend inline fun RestHighLevelClient.putScriptAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: PutStoredScriptRequest.() -> Unit = {}): AcknowledgedResponse =
        awaitAction { putScriptAsync(options, it, block) }

suspend inline fun RestHighLevelClient.rankEvalAsync(rankingEvaluationSpec: RankEvalSpec, indices: Array<String>, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: RankEvalRequest.() -> Unit = {}): RankEvalResponse =
        awaitAction { rankEvalAsync(rankingEvaluationSpec, indices, options, it, block) }

suspend inline fun RestHighLevelClient.reindexAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: ReindexRequest.() -> Unit = {}): BulkByScrollResponse =
        awaitAction { reindexAsync(options, it, block) }

suspend inline fun RestHighLevelClient.reindexRethrottleAsync(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: RethrottleRequest.() -> Unit = {}): ListTasksResponse =
        awaitAction { reindexRethrottleAsync(taskId, requestsPerSecond, options, it, block) }

suspend inline fun RestHighLevelClient.scrollAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: SearchScrollRequest.() -> Unit = {}): SearchResponse =
        awaitAction { scrollAsync(options, it, block) }

suspend inline fun RestHighLevelClient.searchAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: SearchRequest.() -> Unit = {}): SearchResponse =
        awaitAction { searchAsync(options, it, block) }

// TODO searchScroll

suspend inline fun RestHighLevelClient.searchTemplateAsync(script: String, scriptType: ScriptType, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: SearchTemplateRequest.() -> Unit = {}): SearchTemplateResponse =
        awaitAction { searchTemplateAsync(script, scriptType, options, it, block) }

// TODO termvectors

suspend inline fun RestHighLevelClient.updateAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: UpdateRequest.() -> Unit = {}): UpdateResponse =
        awaitAction { updateAsync(options, it, block) }

suspend inline fun RestHighLevelClient.updateByQueryAsync(options: RequestOptions = RequestOptions.DEFAULT, crossinline block: UpdateByQueryRequest.() -> Unit = {}): BulkByScrollResponse =
        awaitAction { updateByQueryAsync(options, it, block) }

suspend inline fun RestHighLevelClient.updateByQueryRethrottleAsync(taskId: TaskId, requestsPerSecond: Float = Float.POSITIVE_INFINITY, options: RequestOptions = RequestOptions.DEFAULT, crossinline block: RethrottleRequest.() -> Unit = {}): ListTasksResponse =
        awaitAction { updateByQueryRethrottleAsync(taskId, requestsPerSecond, options, it, block) }
