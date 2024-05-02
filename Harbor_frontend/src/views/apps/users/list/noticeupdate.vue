<script setup lang="ts">
import { ref } from 'vue';
import { useEditor, EditorContent } from '@tiptap/vue-3';
import StarterKit from '@tiptap/starter-kit';
import UiParentCard from '@/components/shared/UiParentCard.vue';
import EditorMenubar from '@/components/forms/plugins/editor/EditorMenubar.vue';
import { useRouter, useRoute } from 'vue-router';
import BaseBreadcrumb from '@/components/shared/BaseBreadcrumb.vue';

const router = useRouter();
const route = useRoute();  // 현재 라우트에 접근

// 라우트 파라미터에서 공지사항의 제목과 내용을 받아옵니다.
const noticeTitle = ref(route.params.noticeTitle?.toString() || '');
const noticeContent = ref(route.params.noticeContent?.toString() || '');

const editor = useEditor({
  extensions: [StarterKit],
  content: noticeContent.value  // 수정 페이지 로드 시 티업탭 에디터의 내용으로 설정
});
</script>


<template>
  <BaseBreadcrumb :title="page.title" :breadcrumbs="breadcrumbs"></BaseBreadcrumb>
  <UiParentCard title="공지사항 수정하기">
    <v-btn icon flat @click="goBack" size="small"><ChevronLeftIcon size="18" /></v-btn>
    <v-text-field
    v-model="noticeTitle"
    label="제목"
    class="mt-4 mb-4"
    required
    density="comfortable"
    hide-details="auto"
    variant="outlined"
    color="primary"
  ></v-text-field>
    <div v-if="editor">
      <EditorMenubar :editor="editor" />
    </div>
    <editor-content :editor="editor" />
  </UiParentCard>
</template>

<style lang="scss"></style>
